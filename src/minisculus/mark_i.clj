(ns minisculus.mark-i
  (:use [minisculus.core :only (keyboard)]))

(defn- encode-single [source shift]
  (nth (drop-while (complement #{(str source)})
                   (cycle keyboard))
       shift))

(defn rearranged-keyboard [source]
  (mapcat reverse (split-with (complement #{source}) keyboard)))

(defn negative-shift [source shift]
  (if (zero? shift)
    source
    (first (drop (dec shift)
                 (cycle (rearranged-keyboard (str source)))))))

(defn- decode-single [password shift]
  (negative-shift password shift))

(defn compose-translation [pred source & args]
  (apply str (map (fn [letter] (apply pred letter args)) source)))

(defn decode [source shift]
  (compose-translation decode-single source shift))

(defn encode [source shift]
  (compose-translation encode-single source shift))


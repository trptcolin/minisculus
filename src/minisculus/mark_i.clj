(ns minisculus.mark-i
  (:use [minisculus.core :only (keyboard)]))

(defn encode-single [source shift]
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

(defn decode-single [password shift]
  (negative-shift password shift))

(defn decode [password shift]
  (apply str (map #(decode-single % shift) password)))

(defn encode [source shift]
  (apply str (map #(encode-single % shift) source)))


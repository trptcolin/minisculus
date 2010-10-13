(ns minisculus.mark-i
  (:use [minisculus.core :only (keyboard)]))

(defn encode-single [source shift]
  (nth (drop-while (complement #{(str source)})
                   (cycle keyboard))
       shift))

(defn encode [source shift]
  (apply str (map #(encode-single % shift) source)))


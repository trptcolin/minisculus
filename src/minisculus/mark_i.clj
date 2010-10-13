(ns minisculus.mark-i
  (:use [minisculus.core :only (keyboard)]))

(defn translate-single [source shift]
  (nth (drop-while (complement #{(str source)})
                   (cycle keyboard))
       shift))

(defn translate [source shift]
  (apply str (map #(translate-single % shift) source)))


(ns minisculus.mark-i
  (:use [minisculus.core :only (keyboard)]))

(defn translate-single [source shift]
  (nth (drop-while #(not (= source %))
                   (concat keyboard keyboard))
       shift))

(defn translate [source shift]
  (apply str (map #(translate-single (str %) shift) source)))


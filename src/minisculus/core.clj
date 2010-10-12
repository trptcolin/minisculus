(ns minisculus.core)

(def numbers (range 10))
(def uppercase-letters (map char (range 65 91)))
(def lowercase-letters (map char (range 97 123)))
(def symbols [\. \, \? \! \' (char 34) \space])

(def keyboard 
  (concat numbers 
          uppercase-letters
          lowercase-letters
          symbols))

;; TODO: split out to Mark I ns
(defn translate-single [source shift]
  (nth (drop-while #(not (= source %)) 
                   (concat keyboard keyboard))
       shift))

(defn translate [source-chars shift]
  (apply str (map #(translate-single % shift) source-chars)))

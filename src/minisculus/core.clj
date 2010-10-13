(ns minisculus.core)

(def numbers (range 10))
(def uppercase-letters (map char (range 65 91)))
(def lowercase-letters (map char (range 97 123)))
(def symbols [\. \, \? \! \' (char 34) \space])

(def keyboard
  (map str (concat numbers
                   uppercase-letters
                   lowercase-letters
                   symbols)))


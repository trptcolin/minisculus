(ns minisculus.test.mark-ii
  (:use [minisculus.mark-ii]
        [lazytest.describe :only (describe it)]))

(describe "encoding a single character"
  (it (= "S" (encode-single "a" 2 5)))
  (it (= "T" (encode-single "b" 2 5)))
  (it (= "U" (encode-single "c" 2 5))))

(describe "encoding a single character across the keyboard bounds"
  (it (= " " (encode-single "7" 2 5))))

(describe "encoding words / sentences"
  (it (= "STU" (encode "abc" 2 5)))
  (it (= "Wkh2Ghvhuw2Ir.2zloo2pryh2632wdqnv2wr2Fdodlv2dw2gdzq"
         (encode "The Desert Fox will move 30 tanks to Calais at dawn" 9 3))))

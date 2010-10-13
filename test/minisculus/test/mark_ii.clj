(ns minisculus.test.mark-ii
  (:use [minisculus.mark-ii]
        [lazytest.describe :only (describe it)]))

(describe "encoding a single character"
  (it (= "S" (encode "a" 2 5)))
  (it (= "T" (encode "b" 2 5)))
  (it (= "U" (encode "c" 2 5))))

(describe "encoding a single character across the keyboard bounds"
  (it (= " " (encode "7" 2 5))))

(describe "encoding words / sentences"
  (it (= "STU" (encode "abc" 2 5)))
  (it (= "Wkh2Ghvhuw2Ir.2zloo2pryh2632wdqnv2wr2Fdodlv2dw2gdzq"
         (encode "The Desert Fox will move 30 tanks to Calais at dawn" 9 3))))

(describe "decode a single character"
  (it (= "a" (decode "S" 2 5)))
  (it (= "b" (decode "T" 2 5)))
  (it (= "c" (decode "U" 2 5)))
  (it (= "7" (decode " " 2 5))))

(describe "decode words / sentences"
  (it (= "abc" (decode "STU" 2 5)))
  (it (= "The Desert Fox will move 30 tanks to Calais at dawn"
         (decode "Wkh2Ghvhuw2Ir.2zloo2pryh2632wdqnv2wr2Fdodlv2dw2gdzq" 9 3))))



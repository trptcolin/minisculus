(ns minisculus.test.mark-ii
  (:use [minisculus.mark-ii]
        [lazytest.describe :only (describe it)]))

(describe "translating a single character"
  (it (= "S" (translate-single "a" 2 5)))
  (it (= "T" (translate-single "b" 2 5)))
  (it (= "U" (translate-single "c" 2 5))))

(describe "translating a single character across the keyboard bounds"
  (it (= " " (translate-single "7" 2 5))))

(describe "translating words / sentences"
  (it (= "STU" (translate "abc" 2 5)))
  (it (= "Wkh2Ghvhuw2Ir.2zloo2pryh2632wdqnv2wr2Fdodlv2dw2gdzq"
         (translate "The Desert Fox will move 30 tanks to Calais at dawn" 9 3))))

(ns minisculus.test.mark-i
  (:use [minisculus.mark-i]
        [lazytest.describe :only (describe it)]))

(describe "translating a single character"
	(it (= "f" (translate-single "a" 5)))
	(it (= "h" (translate-single "c" 5)))
	(it (= "4" (translate-single " " 5))))

(describe "translate a full word"
  (it (= "hello" (translate "HELLO" 26)))
	(it (= "Yzxutm5TK5cotjy2" (translate "Strong NE Winds!" 6))))

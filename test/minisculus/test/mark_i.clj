(ns minisculus.test.mark-i
  (:use [minisculus.mark-i]
        [lazytest.describe :only (describe it)]))

(describe "translating a single character"
	(it (= "f" (encode-single "a" 5)))
	(it (= "h" (encode-single "c" 5)))
	(it (= "4" (encode-single " " 5))))

(describe "encode a full word"
  (it (= "hello" (encode "HELLO" 26)))
	(it (= "Yzxutm5TK5cotjy2" (encode "Strong NE Winds!" 6))))

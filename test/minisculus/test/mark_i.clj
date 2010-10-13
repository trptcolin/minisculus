(ns minisculus.test.mark-i
  (:use [minisculus.mark-i]
        [lazytest.describe :only (describe it)]))

(describe "encoding a single character"
	(it (= "f" (encode "a" 5)))
	(it (= "h" (encode "c" 5)))
	(it (= "4" (encode " " 5))))

(describe "encode a full word"
  (it (= "hello" (encode "HELLO" 26)))
	(it (= "Yzxutm5TK5cotjy2" (encode "Strong NE Winds!" 6))))

(describe "decode a single character"
  (it (= "a" (decode "f" 5)))
  (it (= "c" (decode "h" 5)))
  (it (= " " (decode "4" 5))))

(describe "decode a full word"
  (it (= "HELLO" (decode "hello" 26)))
  (it (= "Strong NE Winds!" (decode "Yzxutm5TK5cotjy2" 6))))

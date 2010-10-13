(ns minisculus.test.mark-i
  (:use [minisculus.mark-i]
        [lazytest.describe :only (describe it)]))

(describe "encoding a single character"
	(it (= "f" (encode-single "a" 5)))
	(it (= "h" (encode-single "c" 5)))
	(it (= "4" (encode-single " " 5))))

(describe "encode a full word"
  (it (= "hello" (encode "HELLO" 26)))
	(it (= "Yzxutm5TK5cotjy2" (encode "Strong NE Winds!" 6))))

(describe "decode a single character"
  (it (= "a" (decode-single "f" 5)))
  (it (= "c" (decode-single "h" 5)))
  (it (= " " (decode-single "4" 5))))

(describe "decode a full word"
  (it (= "HELLO" (decode "hello" 26)))
  (it (= "Strong NE Winds!" (decode "Yzxutm5TK5cotjy2" 6))))

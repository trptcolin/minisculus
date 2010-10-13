(ns minisculus.test.mark-iv
  (:use [minisculus.mark-iv]
        [lazytest.describe :only (describe it)]))

(describe "encode-single"
  (it (= "e" (encode-single "a" 4 7 "7")))
  (it (= "g" (encode-single "a" 4 7 "8")))
  (it (= "1" (encode-single "1" 4 2 "0")))
  (it (= "3" (encode-single "1" 4 2 "1")))
  )

(describe "encode"
  (it (= "147" (encode "123" 4 2)))
  (it (= "JMl0kBp?20QixoivSc.2\"vvmls8KOk\"0jA,4kgt0OmUb,pm."
      (encode "The white cliffs of Alghero are visible at night" 4 7))))

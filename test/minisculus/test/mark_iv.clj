(ns minisculus.test.mark-iv
  (:use [minisculus.mark-iv]
        [lazytest.describe :only (describe it)]))

(describe "translate-single"
  (it (= "e" (translate-single "a" 4 7 "7")))
  (it (= "g" (translate-single "a" 4 7 "8")))
  (it (= "1" (translate-single "1" 4 2 "0")))
  (it (= "3" (translate-single "1" 4 2 "1")))
  )

(describe "translate"
  (it (= "147" (translate "123" 4 2)))
  (it (= "JMl0kBp?20QixoivSc.2\"vvmls8KOk\"0jA,4kgt0OmUb,pm."
      (translate "The white cliffs of Alghero are visible at night" 4 7))))

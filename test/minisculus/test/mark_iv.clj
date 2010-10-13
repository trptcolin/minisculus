(ns minisculus.test.mark-iv
  (:use [minisculus.mark-iv]
        [lazytest.describe :only (describe it)]))

(describe "encode-single"
  (it (= "e" (encode-single "a" 4 7 "7")))
  (it (= "g" (encode-single "a" 4 7 "8")))
  (it (= "1" (encode-single "1" 4 2 "0")))
  (it (= "3" (encode-single "1" 4 2 "1"))))

(describe "encode"
  (it (= "147" (encode "123" 4 2)))
  (it (= "JMl0kBp?20QixoivSc.2\"vvmls8KOk\"0jA,4kgt0OmUb,pm."
      (encode "The white cliffs of Alghero are visible at night" 4 7))))

(describe "decode-single"
  (it (= "a" (decode-single "e" 4 7 "7")))
  (it (= "a" (decode-single "g" 4 7 "8")))
  (it (= "1" (decode-single "1" 4 2 "0")))
  (it (= "1" (decode-single "3" 4 2 "1")))
  (it (= "e" (decode-single "l" 4 7 "h")))
  )

(describe "decode"
  (it (= "123" (decode "147" 4 2)))
  (it (= "The white cliffs of Alghero are visible at night"
         (decode "JMl0kBp?20QixoivSc.2\"vvmls8KOk\"0jA,4kgt0OmUb,pm." 4 7)))
  (it (= "The rockets will strike at coordinates 49.977984 7.9257857 422979.83 5536735.81 on Oct. 7th"
         (decode "WZyDsL3u'0TfxP06RtSSF 'DbzhdyFIAu2 zF f5KE\"SOQTNA8A\"NCKPOKG5D9GSQE'M86IGFMKE6'K4pEVPK!bv83I" 7 2))))


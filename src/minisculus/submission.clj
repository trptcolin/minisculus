(ns minisculus.submission
  (require [clj-http.client :as client]))

(def starting-point
  {"reference-url" "/questions/14f7ca5f6ff1a5afb9032aa5e533ad95.html",
   "question" "Strong NE Winds!"})

(defn submit-question-1 []
  (client/put
    "http://minisculus.edendevelopment.co.uk/14f7ca5f6ff1a5afb9032aa5e533ad95"
    {:content-type :json,
     :accept :json
     :body "{\"answer\": \"Yzxutm5TK5cotjy2\"}"}))

(def response-1
  {"reference-url" "/questions/2077f244def8a70e5ea758bd8352fcd8.html"
   "question" "The Desert Fox will move 30 tanks to Calais at dawn"})

(defn submit-question-2 []
  (client/put
    "http://minisculus.edendevelopment.co.uk/2077f244def8a70e5ea758bd8352fcd8"
    {:content-type :json,
     :accept :json
     :body "{\"answer\": \"Wkh2Ghvhuw2Ir.2zloo2pryh2632wdqnv2wr2Fdodlv2dw2gdzq\"}"}))

(def response-2
  {"reference-url" "/questions/36d80eb0c50b49a509b49f2424e8c805.html",
   "question" "The white cliffs of Alghero are visible at night"})

(defn submit-question-3 []
  (client/put
    "http://minisculus.edendevelopment.co.uk/36d80eb0c50b49a509b49f2424e8c805"
    {:content-type :json,
     :accept :json
     :body "{\"answer\": \"JMl0kBp?20QixoivSc.2\\\"vvmls8KOk\\\"0jA,4kgt0OmUb,pm.\"}"}))

(def response-3
  {"reference-url" "/questions/4baecf8ca3f98dc13eeecbac263cd3ed.html",
   "question" "WZyDsL3u'0TfxP06RtSSF 'DbzhdyFIAu2 zF f5KE\\\"SOQTNA8A\\\"NCKPOKG5D9GSQE'M86IGFMKE6'K4pEVPK!bv83I"})

(defn submit-question-4 []
  (client/put
    "http://minisculus.edendevelopment.co.uk/4baecf8ca3f98dc13eeecbac263cd3ed"
    {:content-type :json,
     :accept :json
     :body "{\"answer\": \"The rockets will strike at coordinates 49.977984 7.9257857 422979.83 5536735.81 on Oct. 7th\"}"}))

(def response-4
  {"code" "QT4e8MJYVhkls.27BL9,.MSqYSi'IUpAJKWg9Ul9p4o8oUoGy'ITd4d0AJVsLQp4kKJB2rz4dxfahwUa\\\"Wa.MS!k4hs2yY3k8ymnla.MOTxJ6wBM7sC0srXmyAAMl9t\\\"Wk4hs2yYTtH0vwUZp4a\\\"WhB2u,o6.!8Zt\\\"Wf,,eh5tk8WXv9UoM99w2Vr4!.xqA,5MSpWl9p4kJ2oUg'6evkEiQhC'd5d4k0qA'24nEqhtAQmy37il9p4o8vdoVr!xWSkEDn?,iZpw24kF\\\"fhGJZMI8nkI\"
   "email" "minisculus@edendevelopment.co.uk"
   "reference-url" "/finish/50763edaa9d9bd2a9516280e9044d885.html"})

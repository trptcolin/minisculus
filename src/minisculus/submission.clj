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

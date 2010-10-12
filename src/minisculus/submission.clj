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

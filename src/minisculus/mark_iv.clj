(ns minisculus.mark-iv
  (:use [minisculus.core :only (keyboard index-in)])
  (:require [minisculus.mark-i :as mark-i]
            [minisculus.mark-ii :as mark-ii] ))

(defn- shift [letter]
  (* 2 (index-in keyboard letter)))

(defn encode-single [source wheel-1 wheel-2 previous-source]
  (-> source
      (mark-ii/encode wheel-1 wheel-2)
      (mark-i/encode (shift previous-source))))

(defn decode-single [password wheel-1 wheel-2 previous-source]
  (-> password
      (mark-i/decode (shift previous-source))
      (mark-ii/decode wheel-1 wheel-2)))

(defn encode [source wheel-1 wheel-2]
  (let [source   (map str source)
        previous (cons "0" source)]
    (apply str (map (fn [src prev]
                        (encode-single src wheel-1 wheel-2 prev))
                    source
                    previous))))

(defn decode [password wheel-1 wheel-2]
  (let [pw (map str password)]
    (apply str (:solution
      (first (drop (count pw)
        (iterate (fn [{:keys [solution password previous]}]
                     (let [this-solution (decode-single (first password)
                                                       wheel-1
                                                       wheel-2
                                                       previous)]
                      {:solution (conj solution this-solution)
                       :password (rest password)
                       :previous this-solution}))
                 {:solution [] :password pw :previous "0"})))))))

(defn find-decodings-with-word [crypotext plain-word]
  (for [w1 (range 10)
               w2 (range 10)
               :when (re-matches
                       (re-pattern (str "(?i).*" plain-word ".*"))
                       (decode crypotext w1 w2))]
    [w1 w2 (decode crypotext w1 w2)]))


(ns minisculus.mark-iv
  (:use [minisculus.core :only (keyboard index-in)])
  (:require [minisculus.mark-i :as mark-i]
            [minisculus.mark-ii :as mark-ii] ))

(defn encode-single [source wheel-1 wheel-2 previous-source]
  (-> source
      (mark-ii/encode-single wheel-1 wheel-2)
      (mark-i/encode-single
        (* 2 (index-in keyboard previous-source)))))

(defn encode [source wheel-1 wheel-2]
  (let [source (map str source)
        source-with-prev (map vector source (cons "0" source))]
    (apply str (map (fn [[src prev]]
                        (encode-single src wheel-1 wheel-2 prev))
                    source-with-prev))))

(defn decode-single [password wheel-1 wheel-2 previous-source]
  (let [inv-1 (mark-i/decode-single password (* 2 (index-in keyboard previous-source)))]
    (mark-ii/decode-single inv-1 wheel-1 wheel-2)))

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


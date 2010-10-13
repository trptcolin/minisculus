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

(ns minisculus.mark-iv
  (:use [minisculus.core :only (keyboard index-in)])
  (:require [minisculus.mark-i :as mark-i]
            [minisculus.mark-ii :as mark-ii] ))

(defn translate-single [source wheel-1 wheel-2 previous-source]
  (-> source
      (mark-ii/translate-single wheel-1 wheel-2)
      (mark-i/translate-single
        (* 2 (index-in keyboard previous-source)))))

(defn translate [source wheel-1 wheel-2]
  (let [source (map str source)
        source-with-prev (map vector source (cons "0" source))]
    (apply str (map (fn [[src prev]]
                        (translate-single src wheel-1 wheel-2 prev))
                    source-with-prev))))

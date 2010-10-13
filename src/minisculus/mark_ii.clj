(ns minisculus.mark-ii
  (:use [minisculus.core :only (keyboard)])
  (:require [minisculus.mark-i :as mark-i]))

(defn encode-single [source wheel-1 wheel-2]
  (-> source
      (mark-i/encode-single wheel-1)
      (mark-i/negative-shift (* 2 wheel-2))))

(defn encode [source wheel-1 wheel-2]
  (apply str (map #(encode-single % wheel-1 wheel-2) source)))

(defn decode-single [source wheel-1 wheel-2]
  (-> source
      (mark-i/encode-single (* 2 wheel-2))
      (mark-i/negative-shift wheel-1)))

(defn decode [source wheel-1 wheel-2]
  (apply str (map #(decode-single % wheel-1 wheel-2) source)))

(ns minisculus.mark-ii
  (:use [minisculus.core :only (keyboard)])
  (:require [minisculus.mark-i :as mark-i]))

(defn rearranged-keyboard [source]
  (mapcat reverse (split-with (complement #{source}) keyboard)))

(defn negative-shift [source shift]
  (first (drop (dec shift)
               (rearranged-keyboard source))))

(defn encode-single [source wheel-1 wheel-2]
  (-> source
      (mark-i/encode-single wheel-1)
      (negative-shift (* 2 wheel-2))))

(defn encode [source wheel-1 wheel-2]
  (apply str (map #(encode-single % wheel-1 wheel-2) source)))

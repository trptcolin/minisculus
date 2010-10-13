(ns minisculus.mark-ii
  (:use [minisculus.core :only (keyboard)])
  (:require [minisculus.mark-i :as mark-i]))

(defn rearranged-keyboard [source]
  (mapcat reverse (split-with (complement #{source}) keyboard)))

(defn translate-single [source wheel-1 wheel-2]
  (let [shift (- wheel-1 (* 2 wheel-2))]
    (if (< shift 0)
        (first (drop (dec (- shift)) (rearranged-keyboard (str source))))
        (mark-i/translate-single source shift))))

(defn translate [source wheel-1 wheel-2]
  (apply str (map #(translate-single % wheel-1 wheel-2) source)))

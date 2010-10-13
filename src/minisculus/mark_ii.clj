(ns minisculus.mark-ii
  (:use [minisculus.core :only (keyboard)])
  (:require [minisculus.mark-i :as mark-i]))

(defn- shift [wheel]
  (* 2 wheel))

(defn- encode-single [source wheel-1 wheel-2]
  (-> (str source)
      (mark-i/encode wheel-1)
      (mark-i/negative-shift (shift wheel-2))))

(defn- decode-single [source wheel-1 wheel-2]
  (-> (str source)
      (mark-i/encode (shift wheel-2))
      (mark-i/negative-shift wheel-1)))

(defn encode [source wheel-1 wheel-2]
  (mark-i/compose-translation encode-single source wheel-1 wheel-2))

(defn decode [source wheel-1 wheel-2]
  (mark-i/compose-translation decode-single source wheel-1 wheel-2))

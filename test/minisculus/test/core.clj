(ns minisculus.test.core
  (:use [minisculus.core])
  (:use [lazytest.describe :only (describe given it)]))

(describe "keyboard"
  (it (= [  0  1  2  3  4  5  6  7  8  9
				   \A \B \C \D \E \F \G \H \I \J \K \L \M
				   \N \O \P \Q \R \S \T \U \V \W \X \Y \Z
				   \a \b \c \d \e \f \g \h \i \j \k \l \m
				   \n \o \p \q \r \s \t \u \v \w \x \y \z
				   \. \, \? \! \' (char 34) \space ]
				 keyboard)))

(describe "translating a single character"
	(it (= \f (translate-single \a 5)))
	(it (= \h (translate-single \c 5)))
	(it (= 4 (translate-single \space 5))))

(describe "translate a full word"
  (it (= "hello" (translate "HELLO" 26)))
	(it (= "Yzxutm5TK5cotjy2" (translate "Strong NE Winds!" 6))))

(ns endtoend.beget-test
	(:use midje.sweet))

(import org.openqa.selenium.firefox.FirefoxDriver)
(import org.openqa.selenium.By)

;; Why isn't this working?
;; (background (around :contents (let [driver (new FirefoxDriver)] ?form))
;; 						(after  :contents (.quit driver)))

(let [driver (new FirefoxDriver)]
	;; This needs robustification so that the hostname and port used in leiningen to start the server
	;; get used here as well.
	(fact "Page has proper title"
				(.get driver "http://localhost:8080")
				(-> (.findElement driver (By/tagName "title")) (.getText)) => "Beget")
(.quit driver))


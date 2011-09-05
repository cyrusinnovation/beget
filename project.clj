(def appserver-version "1.5.3")
(def appserver-sdk-install-path (str "/usr/local/appengine-java-sdk-" appserver-version))
(def appserver-address "localhost")
(def appserver-port "8080")

(defproject beget "0.2.0"
	
	:repositories {"sonatype-releases" "https://oss.sonatype.org/content/repositories/releases"
								 "sonatype-snapshots" "https://oss.sonatype.org/content/repositories/snapshots"}

  :dependencies [[compojure "0.6.5"]
                 [hiccup "0.3.6"]
                 [org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [ring "0.3.11"]
                 [com.google.appengine/appengine-tools-sdk ~appserver-version]]

  :dev-dependencies [[midje "1.2.0"]
										 [lein-midje "1.0.3"] 
										 [org.seleniumhq.selenium/selenium-java "2.5.0"]
										 [com.google.appengine/appengine-testing ~appserver-version]]

	:aot [beget]
  :compile-path "war/WEB-INF/classes/"
  :library-path "war/WEB-INF/lib/")


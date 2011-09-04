(ns leiningen.core
  (use [lancet.core :only [exec]]))             ; add needed ant tasks here

(def appserver-version "1.5.3")
(def appserver-sdk-install-path (str "/usr/local/appengine-java-sdk-" appserver-version))
(def appserver-address "localhost")
(def appserver-port "8080")

(defproject beget "0.1.0-SNAPSHOT"
  :dependencies [[org.buntin/compojure "0.4.0-SNAPSHOT"]
                 [hiccup "0.4.0-SNAPSHOT"]
                 [org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [ring "0.1.1-SNAPSHOT"]
                 [com.google.appengine/appengine-tools-sdk ~appserver-version]]
  :dev-dependencies [[swank-clojure "1.3.2"]
										 [com.google.appengine/appengine-testing ~appserver-version]]
  :namespaces [beget]
  :compile-path "war/WEB-INF/classes/"
  :library-path "war/WEB-INF/lib/")


(defn run-shell-command [cmd & args]
  (apply exec {:executable cmd :spawn "true"} args))

(defn dev-appserver []
	(run-shell-command "java"
										 "-ea"
										 "-cp"
										 (str leiningen.core/appserver-sdk-install-path "/lib/appengine-tools-api.jar")
										 "com.google.appengine.tools.KickStart"
										 "com.google.appengine.tools.development.DevAppServerMain"
										 (str "--address=" leiningen.core/appserver-address)
										 (str "--port=" leiningen.core/appserver-port)
										 "war"))

(defn kill-appserver []
	(run-shell-command "script/kill_appserver.sh"))

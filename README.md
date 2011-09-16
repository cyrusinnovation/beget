Beget
=====

Sample Google App Engine project with Clojure and Leiningen, now with
server controls and Selenium tests. The tests are driven by Brian Marick's
midje test framework.

Usage
=====

        $ lein deps

        $ lein compile

        $ lein gae start # Starts the development appserver

        $ lein midje 	# Runs the tests

        $ lein gae stop  # Stops the development appserver

        $ lein test 	 # Starts the dev server, runs the tests, and stops the server.
						 # For this you also need to add the Firefox binary to your PATH
						 # E.g.,  $>	export PATH=$PATH:/Applications/Firefox.app/Contents/MacOS

				
Running the server requires the [Google App Engine SDK](http://code.google.com/appengine/downloads.html). 
You will need to edit the project.clj file to indicate the version
number of the App Engine SDK as well as the path where it is installed.
The shell scripts that start and stop the server (in the script/ directory) currently presuppose some flavor
of UNIX, and have only been tested on OS X.

# httpclientandroid

This project is __*actively maintained for [ODK-X](https://docs.opendatakit.org/odk-x/)*__. It was replaced by [OkHttp](https://square.github.io/okhttp/) in ODK Collect 1.23.

This is a script to change the package name of stock apache http client libraries so that newer libraries can 
be used on Android (otherwise, each Android OS release specifies its own version of these libraries).

This is a modified copy of the script written by Dirk Boyle and made available in the httpclientandroidlib Google Code project. Changes have been made in the logging code and to update the versions of the source apache libraries.

The resulting httpclientandroidlib.jar is used by ODK-X Android tools.

#  Exercise

# Dependencies

This project requires maven and Java 17 or later. Unit tests require junit-jupiter.

# Compiling

To compile, execute:

    mvn clean compile

# Unit tests

To run unit tests, execute:

    mvn clean test

# Executing the application

The application consumes input from STDIN and writes output to STDOUT.

The application must be compiled first (see above). After compiling, to
execute against the provided sample input file and send the output to
the output.txt file, execute:

    ./gravity.sh < input.txt > output.txt

## Enabling debug output

The application includes basic debug output. This can be enabled by including
any non-null string as an argument to the program, eg:

    ./gravity.sh debug < input.txt

# Netbeans Php blade editor

Netbeans Php blade editor using Antlr Lexer and Parser.

## Known issues

The filesystem management in netbeans is not adapted to handle grouped extensions ".blade.php". This will cause issues when duplicating a file or creating a new file, as the referenced filename name will include the ".blade" extension

Unfortunatelly, for the moment, there is no workaround this.

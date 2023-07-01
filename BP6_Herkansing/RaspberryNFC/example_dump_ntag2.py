import time

import RPi.GPIO as GPIO
import mysql as mysql
import mysql.connector as mdb

import pn532.pn532 as nfc
from pn532 import *

# Deze code is afkomstig van de officiele documentatie van de PN532 scanner
# De code is aangepast voor het project, maar komt grootendeels overeen
# Er zijn stukken code uitgezet die niet nodig waren

# De benodigde strings om connectie te kunnen maken met de database
hostDB = 'www.adainforma.tk'
DB = 'projects_adakenniscentrum'
userDB = 'adakenniscentrum'
passwordDB = 'U5Qq&#Ry+s'

connection = mysql.connector.connect(host=hostDB, database=DB,user = userDB, password = passwordDB)

pn532 = PN532_SPI(cs=4, reset=20, debug=False)
#pn532 = PN532_I2C(debug=False, reset=20, req=16)
#pn532 = PN532_UART(debug=False, reset=20)

ic, ver, rev, support = pn532.get_firmware_version()
print('Found PN532 with firmware version: {0}.{1}'.format(ver, rev))

# Configure PN532 to communicate with NTAG215 cards
pn532.SAM_configuration()

print('Waiting for RFID/NFC card to read from!')
while True:
    while True:
        # Controleer of er een kaart beschikbaar is om te lezen
        uid = pn532.read_passive_target(timeout=0.5)
        # Probeer opnieuw als er geen kaart beschikbaar is.
        if uid is not None:
            break

    try:
        # Converteer de gelezen bytes van de PN532 naar een hexadecimale string
        res = bytes.fromhex(' '.join(['%02X' % x for x in pn532.ntag2xx_read_block(6)])).decode()
        print("code= " + res)

        # Bouw de SQL-query om de gelezen NFCID en de huidige tijd in de database in te voegen
        sQuery = "INSERT INTO `ScannedNFC` (`NFCID`,`Time`,`Processed`) VALUES ( '" + res + "', NOW() , 0);"
        cursor = connection.cursor()
        result = cursor.execute(sQuery)
        connection.commit()

        # Wacht 5 seconden voordat verder te gaan
        time.sleep(5)
    except nfc.PN532Error as e:
        print(e.errmsg)

    # Ruim de GPIO-pinnen op na het verlaten van de try-except blok
    GPIO.cleanup()

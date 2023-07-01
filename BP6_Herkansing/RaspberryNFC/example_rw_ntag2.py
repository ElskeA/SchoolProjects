import RPi.GPIO as GPIO
import pn532.pn532 as nfc

from pn532 import *

# Deze code is afkomstig van de officiele documentatie van de PN532 scanner
# De code is aangepast voor het project, maar komt grootendeels overeen
# Er zijn stukken code uitgezet die niet nodig waren

pn532 = PN532_SPI(debug=False, reset=20, cs=4)
#pn532 = PN532_I2C(debug=False, reset=20, req=16)
#pn532 = PN532_UART(debug=False, reset=20)

ic, ver, rev, support = pn532.get_firmware_version()
print('Found PN532 with firmware version: {0}.{1}'.format(ver, rev))

# Configure PN532 to communicate with NTAG215 cards
pn532.SAM_configuration()

print('Waiting for RFID/NFC card to write to!')
while True:
    # Controleer of er een kaart beschikbaar is om te lezen
    uid = pn532.read_passive_target(timeout=0.5)
    print('.', end="")
    # Probeer opnieuw als er geen kaart beschikbaar is.
    if uid is not None:
        break

print('Gevonden kaart met UID:', [hex(i) for i in uid])

# Schrijf naar blok #6
block_number = 6
data = bytes('dbdb', 'utf-8')

try:
    pn532.ntag2xx_write_block(block_number, data)
    if pn532.ntag2xx_read_block(block_number) == data:
        print('Blok %d succesvol geschreven' % block_number)
except nfc.PN532Error as e:
    print(e.errmsg)

# Ruim de GPIO-pinnen op na het verlaten van de try-except blok
GPIO.cleanup()

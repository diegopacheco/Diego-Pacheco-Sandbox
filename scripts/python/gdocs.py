import gspread

gc = gspread.login('user','pass')

worksheet = gc.open('nome_planilha').sheet1

val = worksheet.acell('C2').value

print val
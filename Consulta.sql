SELECT *FROM Arquivo ; 

SELECT *FROM Regiao WHERE sigla = 'SE' ; 
SELECT *FROM Compra ; 



SELECT   ( 

SELECT 
SUM(co.valor) valorA 
###* 
 FROM Regiao re 
INNER JOIN Compra co ON re.id = co.id_regiao 
WHERE   re.sigla = 'SE' ### AND re.id = 9   

) AS  A     ;  




SELECT SUM(co.valor) valorA  FROM Regiao re INNER JOIN Compra co ON re.id = co.id_regiao 
WHERE re.sigla = 'SE'


SELECT SUM(ge.valor) valorA  FROM Regiao re INNER JOIN Geracao ge ON re.id = ge.id_regiao 
WHERE re.sigla = 'SE'



SELECT SUM(pe.valor) valorA  FROM Regiao re INNER JOIN Preco_Medio pe ON re.id = pe.id_regiao 
WHERE re.sigla = 'SE'






DELETE FROM `Compra` ; 
DELETE FROM `Preco_Medio` ; 
DELETE FROM `Geracao` ;
DELETE FROM `Regiao` ; 
DELETE FROM `Agente` ; 
DELETE FROM `Arquivo` ;





SELECT *from Agente WHERE id = 1547 ;  ##codigo 512 
SELECT *FROM Regiao WHERE id_agente = 1547 ; 
SELECT *FROM Geracao WHERE id_regiao IN (6141,6162,6174,6182 ); 
SELECT *FROM Compra WHERE id_regiao IN (6141,6162,6174,6182 ); 
SELECT *FROM Preco_Medio WHERE id_regiao IN (6141,6162,6174,6182 ); 




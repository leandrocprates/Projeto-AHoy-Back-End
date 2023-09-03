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
WHERE re.sigla = :sigla





DELETE FROM `Compra` ; 
DELETE FROM `Preco_Medio` ; 
DELETE FROM `Geracao` ;
DELETE FROM `Regiao` ; 
DELETE FROM `Agente` ; 
DELETE FROM `Arquivo` ;




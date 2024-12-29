import mysql.connector
import pandas as pd

# Configuration de la connexion
connection = mysql.connector.connect(
    host="localhost",  # Utilisez "db" si vous exécutez ce script dans un autre conteneur Docker
    port=3306,
    user="db"
)

# Requête SQL
query = "SELECT * FROM bloc"

# Exécution de la requête et conversion en DataFrame
try:
    df = pd.read_sql(query, connection)
    df.to_csv('extracted_data.csv', index=False)
    print("Extraction des données réussie.")
except Exception as e:
    print(f"Erreur lors de l'extraction des données : {e}")
finally:
    connection.close()

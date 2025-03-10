import mysql.connector
import pandas as pd

# MySQL connection configuration
db_config = {
    'host': 'localhost',      # MySQL server host (use your MySQL server IP or hostname)
    'user': 'root',  # Your MySQL username
    'password': 'root',  # Your MySQL password
    'database': 'your_database'  # Your database name
}

# CSV file path
csv_file = '"C:\\Users\\dburn\\Downloads\\books.csv"'

# Connect to MySQL
conn = mysql.connector.connect(**db_config)
cursor = conn.cursor()

# Load the CSV into a pandas DataFrame
df = pd.read_csv(csv_file)

# Insert data into MySQL
for i, row in df.iterrows():
    # Build the INSERT query
    insert_query = f"INSERT INTO books (id, title, author) VALUES (%s, %s, %s)"
    
    # Extract data from each row and insert
    cursor.execute(insert_query, tuple(row))
    conn.commit()

print(f"Successfully inserted {len(df)} rows.")

# Close the connection
cursor.close()
conn.close()

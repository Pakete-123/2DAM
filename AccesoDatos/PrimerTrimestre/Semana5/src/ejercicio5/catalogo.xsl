<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/biblioteca">
    <html lang="es">
      <head>
        <title>Catálogo</title>
        <style>
          body {
            font-family: Arial, sans-serif;
            margin: 2rem;
          }
          table {
            border-collapse: collapse;
            min-width: 600px;
          }
          th,
          td {
            border: 1px solid #999;
            padding: 8px 12px;
            text-align: left;
          }
          th {
            background-color: #2c5282;
            color: #fff;
          }
          tr:nth-child(even) {
            background-color: #f2f2f2;
          }
          td.precio {
            text-align: right;
          }
        </style>
      </head>
      <body>
        <h1>Catálogo</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Título</th>
              <th>Autor</th>
              <th>Precio</th>
            </tr>
          </thead>
          <tbody>
            <xsl:for-each select="libro">
              <tr>
                <td><xsl:value-of select="@id" /></td>
                <td><xsl:value-of select="titulo" /></td>
                <td><xsl:value-of select="autor" /></td>
                <td class="precio"><xsl:value-of select="precio" /> €</td>
              </tr>
            </xsl:for-each>
          </tbody>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
	Design by Free CSS Templates
	http://www.freecsstemplates.org
	Released for free under a Creative Commons Attribution 2.5 License
-->
<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="DAO.*" %>
<%@ page import ="Bean.*" %>
<%@ page import ="Conexao.*" %>
<%@ page import ="Controlador.*" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<title>Classificados WEB</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="outer">
	
  <div id="header"> 
    <h1><a href="#">Classificados WEB</a></h1>
    <h2>Gestão de Classificados pela Internet</h2>
  </div>
  <div id="menu"> 
    <ul>
      <li class="first"><a href="index.html" accesskey="1" title="">Início</a></li>
	  <li class="first"><a href="cad-gerenciar_cliente.jsp" accesskey="2" title="">Clientes</a></li>
	  <li class="first"><a href="cad-gerenciar_tipoanuncio.jsp" accesskey="3" title="">Endereços</a></li>
	  <li class="first"><a href="cad-gerenciar_funcionario.jsp" accesskey="4" title="">ItemTema</a></li>
	  <li class="first"><a href="cad-gerenciar_sessao.jsp" accesskey="1" title="">Tema</a></li>
      <li></li>
    </ul>
  </div>

<div id="content">
		<div id="primaryContentContainer">
			<div id="primaryContent">
				
        <h2>Gerenciar ItemTema</h2>
        <form name="form1" id="form1" method="post" action="ServletGerenciarItem_Tema">
          <table border="0">
            <tr> 
              <td width="235">idItem:</td>
              <td width="602"><input name="idfunc" type="text" id="idfunc" /></td>
            </tr>
            <tr> 
              <td>Nome do Item:</td>
              <td><input name="nomefunc" type="text" id="nomefunc" size="50" maxlength="45" /></td>
            </tr>
            <tr> 
              <td>Opera&ccedil;&atilde;o:</td>
              <td><input type="submit" name="Submit" value="&lt;&lt;&lt;&lt; Incluir &gt;&gt;&gt;&gt;" />
                - <a href="ServletListagemItem_Tema">Listar Todos os Funcion&aacute;rios</a>.</td>
            </tr>
            <tr> 
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr> 
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="2"><div align="center"><font size="2">Copyright &copy; 
                  2011 Sitename.com. Designed by <a href="http://www.freecsstemplates.org">Free 
                  CSS Templates</a> - Desenvolvido por: Ricardo Roberto de Lima 
                  em 2011.</font></div></td>
            </tr>
          </table>
        </form>
        <p>&nbsp; </p>
        </div>
		</div>
			<div id="secondaryContent">
			
      <h3><a href="index.html" accesskey="1" title="">Início</a></h3>
	  <h3><a href="cad-gerenciar_cliente.jsp" accesskey="2" title="">Clientes</a></h3>
	  <h3><a href="cad-gerenciar_tipoanuncio.jsp" accesskey="3" title="">Endereços</a></h3>
	  <h3><a href="cad-gerenciar_funcionario.jsp" accesskey="4" title="">ItemTema</a></h3>
	  <h3><a href="cad-gerenciar_sessao.jsp" accesskey="1" title="">Tema</a></h3>
    </div>
  </div>
	<div id="footer">
		
    <p>&nbsp;</p>
	</div>
</div>
</body>
</html>

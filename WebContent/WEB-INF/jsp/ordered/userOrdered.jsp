<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Meus <strong>Pedidos</strong></span></span></span>
            </h4>

				<div class="row">
					<div class="span11">
					<c:choose>					
						<c:when test="${fn:length(ordered) gt 0}" >
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Número do Pedido</th>
										<th>Data</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ordered}" var="order" >
										<tr>
											<td>${order.id}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${order.insertDate}" /></td>
											<td><fmt:message key="user.status.${order.status}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							Você não tem nenhum pedido pendente.
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			
			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/app/app.cart.js"></script>
		</div>		
    </body>
</html>
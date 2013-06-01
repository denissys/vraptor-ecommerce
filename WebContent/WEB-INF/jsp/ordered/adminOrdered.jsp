<%@page import="br.com.kwikemart.enums.OrderStatus"%>
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
						<form id="form-filter" action="/pedidos/admin/status" method="GET">
							Filtrar Pedidos por status:					
							<select id="select-status" name="status">
								<option value="">Selecione um status</option>
								<c:forEach items="<%=OrderStatus.values() %>" var="value" >
									<option value="${value}" ${param.status == value ? 'selected="selected"' : ''} ><fmt:message key="OrderStatus.${value}"/></option>
								</c:forEach>
							</select>
						</form>
					</div>
					<div class="span11">
					<c:choose>					
						<c:when test="${fn:length(ordered) gt 0}" >
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Número do Pedido</th>
										<th>Data da Compra</th>
										<th>Cliente</th>
										<th>Status</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ordered}" var="order" >
										<tr>
											<td>${order.id}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${order.insertDate}" /></td>
											<td>${order.user.firstName}</td>
											<td>
												<select id="select-status-${order.id}">
													<c:forEach items="<%=OrderStatus.values() %>" var="value" >
														<option value="${value}" ${order.status == value ? 'selected="selected"' : ''} ><fmt:message key="OrderStatus.${value}"/></option>
													</c:forEach>
												</select>
											</td>
											<td>
												<button id="update-status" class="btn btn-success" type="button" data-id="${order.id}">Atualizar Status</button>
												<button id="view-order" class="btn btn-warning" type="button" data-id="${order.id}">Ver Pedido</button>
											</td>
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
			<script type="text/javascript" src="/assets/js/app/app.order-admin.js"></script>
		</div>		
    </body>
</html>
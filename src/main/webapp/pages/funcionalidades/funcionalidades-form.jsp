<%@ include file="../template/header.jsp" %>


<div class="col-12">
    <section class="section">
        <div class="card">
            <div class="card-header alert alert-secondary">

                <c:if test="${f.id != null}">
                    <h4 class="card-title">
                        <b>ALTERAR</b>
                    </h4>
                </c:if>

                <c:if test="${f.id == null}">
                    <h4 class="card-title">
                        <b>CADASTRAR</b>
                    </h4>
                </c:if>

            </div>

            <div class="card-body">
                <form:form method="POST" modelAttribute="f" name="f" action="funcionalidades-save">
                    <form:hidden path="uuid"/>

                    <div class="row">
                        <div class="col-md-4">

                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <form:input path="nome" cssClass="form-control" id="nome"/>
                                <form:errors path="nome" cssClass="text-danger"/>
                            </div>

                            <div class="form-group">
                                <label for="descricao">Endereço</label>
                                <form:input path="descricao" cssClass="form-control" id="descricao"/>
                                <form:errors path="descricao" cssClass="text-danger"/>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-12">
                                    <a href="${contextPath}/funcionalidades">
                                        <button type="button" class="btn btn-secondary btn-block  mt-5">VOLTAR</button>
                                    </a>
                                </div>
                                <div class="col-lg-6 col-12">
                                    <button class="btn btn-primary btn-block mt-5" type="submit">GRAVAR</button>
                                </div>

                            </div>


                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </section>
</div>


<%@ include file="../template/footer.jsp" %>


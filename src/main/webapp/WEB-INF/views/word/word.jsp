<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>単語連想アプリ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <h1>単語連想アプリ</h1>
        <hr>

        <section id="input-form">
            <h2>単語を入力してください（英単語がおすすめ）</h2>
            <form action="submit" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                
                <label for="mainWord">メイン単語：</label>
                <input type="text" id="mainWord" name="mainWord" required><br><br>

                <label for="otherWord1">連想単語1：</label>
                <input type="text" id="otherWord1" name="otherWords" required><br><br>

                <label for="otherWord2">連想単語2：</label>
                <input type="text" id="otherWord2" name="otherWords" required><br><br>

                <label for="otherWord3">連想単語3：</label>
                <input type="text" id="otherWord3" name="otherWords" required><br><br>

                <label for="otherWord4">連想単語4：</label>
                <input type="text" id="otherWord4" name="otherWords" required><br><br>

                <label for="otherWord5">連想単語5：</label>
                <input type="text" id="otherWord5" name="otherWords" required><br><br>

                <input type="submit" value="実行">
            </form>
        </section>

        <hr>

        <section id="result">
            <h2>結果</h2>
            <p><strong>メイン単語:</strong> ${resultwordList[0].mainWord}</p>
            <p><strong>連想単語と相関値:</strong></p>
            <ul>
                <c:forEach var="word" items="${resultwordList[0].otherWords}" varStatus="status">
                    <li>
                        <span>${word}</span>
                        <span>: ${resultwordList[0].correlationValues[status.index]}</span>
                    </li>
                </c:forEach>
            </ul>
        </section>
        <h1>
            <a href="${pageContext.request.contextPath}">遊び方を見る</a>
        </h1>
    </div>
</body>
</html>

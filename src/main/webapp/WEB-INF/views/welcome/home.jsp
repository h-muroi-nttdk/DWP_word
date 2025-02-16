<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>単語連想アプリ</title>
    <link rel<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
    <div id="wrapper">
        <h1 id="title">単語連想アプリ</h1>
        <hr>
        <section id="how-to-play">
            <h2>アプリ説明</h2>
            <ol>
            OpenAIのembeddingAPIを用いて、情報検索時の人間の「なんとなく」という感覚を実現するアプリです。
            通常システムで情報検索をしようとすると、SQLのWhere句やキーペアを用いないと検索ができませんが、
            それらを用いず、「人間の感覚だったらこれだよね」を実現するアプリです。<br>
            <h5>
            	<a href="https://qiita.com/takarui/items/bce75aad95f1df17e93d">embeddingAPIについて</a>
            </h5>
            </ol>
        
        <section id="how-to-play">
            <h2>遊び方</h2>
            <ol>
                <li>メイン単語を入力します。<br>例：Apple</li>
                <li>メイン単語から連想される単語を含む、5つの単語を入力します。<br>例：Windows、mac、Linux、iOS、Android</li>
                <li>「実行」ボタンを押し、連想されるべき単語が上位に表示されているか確認します。今回で言えば、mac、iOS。</li>
                <li>実際の画面
            </ol>
        </section>
    <img src="${pageContext.request.contextPath}/resources/app/img/asobikata.png" alt="遊び方">
	    <h1>
	        <a href="${pageContext.request.contextPath}/word/list">遊ぶ！</a>
	    </h1>
    </div>
</body>
</html>

おおまかな流れ

サーバ起動時に
1. com.example.demo.service.TestService.runメソッドが呼ばれる
2. その中で com.example.demo.util.ReschedulableExecutor.startメソッドが呼ばれる
3. その中の scheduleAtFixedRateメソッドで一定時間ごとにプライベートクラスの TimerTask の runメソッドが呼ばれる
4. またその中で com.example.demo.service.TestServiceのprivate class TimerTask の run が呼ばれる
結果、Config.properties で定義された scheduler.interval の値(秒)ごとにログがかかれます。

localhost:8080/ にアクセスすると
インターバル時間、初期実行までの待機時間を再設定できるようになっています。
（エラーチェック等はしていないので、数値以外を入力するとエラーで落ちます）


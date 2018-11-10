おおまかな流れ

サーバ起動時に
1. com.example.demo.service.TestService.runメソッドが呼ばれる
2. その中でcom.example.demo.util.ReschedulableExecutorのプライベートクラスの TimerTask の runメソッドが呼ばれる
3. またその中で com.example.demo.service.TestServiceのprivate class TimerTask の run が呼ばれる

結果、Config.properties で定義された scheduler.interval の値(秒)ごとにログがかかれます。

localhost:8080/ にアクセスすると
インターバル時間、初期実行までの待機時間を再設定できるようになっています。
（エラーチェック等はしていないので、数値以外を入力すると死にます）

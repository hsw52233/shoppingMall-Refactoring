# **ショッピングモールプロジェクト 🛒**  
 

---

## **担当役割 🎯**
👨‍💻 **ハ・サンウ**：管理者モード担当（管理者ページ全般）  

---

## 概要 📝
- **Spring Boot**と**MySQL / MyBatis**を使用したショッピングモールWebサイト。
- 会員モードと管理者モードの機能を中心に構築。
- 開発期間：2024/11/25 ～ 2024/12/08  

---

## 主要機能 💡

### 会員モード 🕵️‍♀️
#### ログイン 🔑
![ログインページ](https://github.com/user-attachments/assets/5d1e7e5d-1874-4a79-9b2f-400f507575e6)<br>
- 会員番号とパスワードで認証。  
- 認証成功時にメインページへリダイレクト。  
- クッキーで会員番号を保存可能。 🍪

#### 商品一覧ページ 🛍️
![商品メインページ](https://github.com/user-attachments/assets/6dbd9da5-7d6d-4839-8a7e-8e50c12d0812)<br>
- 商品をリスト表示。  
- 商品詳細ページでレビュー確認、カート追加可能。  

#### カート機能 🛒
![カートページ](https://github.com/user-attachments/assets/26564a9c-5858-4448-84c9-6173f56fc16d)<br>
- カート内の商品一覧を表示。  
- 削除、数量変更、決済処理対応。  

#### 注文履歴 📝
![注文履歴ページ](https://github.com/user-attachments/assets/408599a6-7452-44ed-b65f-821248e1a96b)<br>
- 注文状態（配送中、決済完了など）の確認。  

---

### 管理者モード 🔍
#### スタッフ一覧 📝
![スタッフリスト](https://github.com/user-attachments/assets/30350198-0ba5-4485-a533-d76813cb1ed4)<br>
- スタッフ情報の閲覧・編集・削除が可能。  

#### 商品管理 🛠️
![商品リスト](https://github.com/user-attachments/assets/2286dd15-6cca-4bda-91c7-92bb4aef4fa8)<br>
- 商品の登録、編集、削除が可能。  

#### 会員管理 🧑‍🤝‍🧑
![会員ページ](https://github.com/user-attachments/assets/ff04b305-ef87-498b-bd75-0856aced548c)<br>
- 登録会員の確認と削除。  

#### レビュー管理 ⚠️
![レビューリスト](https://github.com/user-attachments/assets/e8ea3f9c-58f1-4a5f-8e21-8626ba9f3c23)<br>
- 投稿レビューの確認・削除。  

---

## データベース構造 💾
![ショッピングモールDB](https://github.com/user-attachments/assets/dadff1ad-e945-4768-8597-224de2c975ec)  

---

## 技術スタック 💻
| 分類 | 技術・ツール |
|------|-----------------------------------------------------------|
| 🌐 **バックエンド** | ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black) |
| 🎨 **フロントエンド** | ![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white) |
| 📜 **テンプレートエンジン** | ![JSP](https://img.shields.io/badge/JSP-0075B8?style=for-the-badge&logo=java&logoColor=white) |
| 💾 **データベース** | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![MySQL Workbench](https://img.shields.io/badge/MySQL%20Workbench-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| 🤝 **協業・デザイン** | ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) ![Obsidian](https://img.shields.io/badge/Obsidian-453A5D?style=for-the-badge&logo=obsidian&logoColor=white) |
| 🔧 **開発ツール** | ![STS](https://img.shields.io/badge/Spring%20Tool%20Suite-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![FileZilla](https://img.shields.io/badge/FileZilla-BF0000?style=for-the-badge&logo=filezilla&logoColor=white) |

---

## チーム情報 🧑‍🤝‍🧑
| 名前 | GitHub | 担当 |
|------|--------|------|
| 👨‍💻 **ハ・サンウ** | [https://github.com/hsw52233](https://github.com/hsw52233) | 管理者モード担当（管理者ページ全般） |
| 👨‍💻 **イ・ドンユン** | [https://github.com/LYUN555](https://github.com/LYUN555) | 会員モード担当 |

---

## セットアップ方法 ⚙️
1. **データベース設定**  
- [SQLファイルをダウンロード](https://drive.google.com/file/d/17OUra5EzRRnyzsZAxfktDzymbBt9tjb_/view?usp=sharing)し、MySQLで実行。
2. **プロジェクト実行**  
- 'src/main/resources'に [application-db](https://drive.google.com/file/d/1hesSD3dLRiLO8sjO2pJfjkEgsqXABoL4/view?usp=sharing) ファイルを追加。  
- Spring Tool Suiteで起動。  
- ブラウザで `http://localhost:8080` にアクセス。
3. **ログイン**  
- サンプルアカウントでログインして確認可能。

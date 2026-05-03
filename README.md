# **쇼핑몰 프로젝트 🛒**

[日本語版はこちら](./README_JP.md) 

## 개요 📝
- **Spring Boot**기반으로 **MySQL**과 **MyBatis**를 활용하여 제작한 쇼핑몰 웹 사이트.
- 관리자모드와 회원모드를 중심으로 시스템을 개발. 🎯
- 2024/11/25부터 2024/12/08까지 해당 프로젝트를 진행.

<br>

## 주요기능 💡
### 로그인 🔑
![로그인페이지](https://github.com/user-attachments/assets/5d1e7e5d-1874-4a79-9b2f-400f507575e6)<br>
- 사용자는 사원번호와 비밀번호를 입력해야 합니다. 🔑
- 올바른 인증 정보 입력 시 메인 페이지로 이동합니다. ✔️
- 사원번호를 브라우저 쿠키에 저장하여 이후 로그인 시 자동 입력 가능합니다. 🍪
---
### 회원모드 🕵️‍♀️
### 상품 메인 페이지
![상품메인페이지](https://github.com/user-attachments/assets/6dbd9da5-7d6d-4839-8a7e-8e50c12d0812)<br>
- 로그인을 하면 메인 페이지에 상품들이 나열되어 있습니다.🔑 
- 원하는 상품을 클릭하면 상품 상세 정보와 장바구니 추가 기능이 있습니다.🛒 
- 상품 상세에는 후기도 볼 수 있기 때문에 구매 시 참고 할 수 있도록 구현했습니다.⭐
---
### 장바구니 🛍️
![장바구니](https://github.com/user-attachments/assets/26564a9c-5858-4448-84c9-6173f56fc16d)<br>
- 🛒 장바구니에서는 내가 담은 상품들을 리스트로 확인할 수 있고 🗑️ 삭제도 가능합니다.
- 💰 결제 금액, 📍 배송지, 💳 결제 방식을 선택하여 바로 상품을 결제할 수 있습니다.
---
### 주문내역 📝
![주문내역](https://github.com/user-attachments/assets/408599a6-7452-44ed-b65f-821248e1a96b)<br>
- 📦 내 주문 내역을 리스트로 한눈에 확인할 수 있습니다.
- 🚚 배송 중, ✅ 결제 완료 상태를 확인할 수 있습니다.
---

### 관리자모드 🔍
### 스태프 리스트 📝
![스태프리스트](https://github.com/user-attachments/assets/30350198-0ba5-4485-a533-d76813cb1ed4)<br>
- 📂 왼쪽 사이드바를 이용해 원하는 곳으로 이동할 수 있습니다.
- 👥 스태프 정보를 한눈에 확인할 수 있습니다.
---
### 상품리스트 📝
![상품리스트(관리자)](https://github.com/user-attachments/assets/2286dd15-6cca-4bda-91c7-92bb4aef4fa8)<br>
- 📋 쇼핑몰에 등록된 상품들을 리스트로 한눈에 확인할 수 있습니다.
- ➕ 새로운 상품을 등록하여 쇼핑몰에 추가할 수 있습니다.
- ✏️ 상품 정보 수정, 🗑️ 불필요한 상품 삭제도 가능합니다.
---
### 회원 페이지 📝
![회원페이지](https://github.com/user-attachments/assets/ff04b305-ef87-498b-bd75-0856aced548c)<br>
- 🧑‍🤝‍🧑 등록된 회원 리스트를 볼 수 있습니다.
- 🛠️ 관리자 권한으로 🗑️ 회원 삭제도 가능합니다.
---
### 리뷰 관리 📝
![리뷰리스트](https://github.com/user-attachments/assets/e8ea3f9c-58f1-4a5f-8e21-8626ba9f3c23)<br>
- 📝 상품에 등록된 리뷰들을 관리합니다.
- ⚠️ 불미스러운 리뷰는 🛠️ 관리자 모드에서 🗑️ 삭제할 수 있습니다.
---

<br><br>

## 데이터베이스 구조 💾
![쇼핑몰DB](https://github.com/user-attachments/assets/dadff1ad-e945-4768-8597-224de2c975ec)<br>  
 

<br><br>

## 사용된 기술 스택 💻
| **분류**          | **기술 및 도구** |
|------------------|---------------------------------------------------------------|
| 🌐 **백엔드**     | ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black) |
| 🎨 **프론트엔드** | ![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white) |
| 📜 **템플릿 엔진** | ![JSP](https://img.shields.io/badge/JSP-0075B8?style=for-the-badge&logo=java&logoColor=white) |
| 💾 **데이터베이스** | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![MySQL Workbench](https://img.shields.io/badge/MySQL%20Workbench-4479A1?style=for-the-badge&logo=mysql&logoColor=white) |
| 🤝 **협업 및 디자인** | ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) ![Obsidian](https://img.shields.io/badge/Obsidian-453A5D?style=for-the-badge&logo=obsidian&logoColor=white)|
| 🔧 **개발 도구**   | ![STS](https://img.shields.io/badge/Spring%20Tool%20Suite-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![FileZilla](https://img.shields.io/badge/FileZilla-BF0000?style=for-the-badge&logo=filezilla&logoColor=white) |

<br><br>


## 팀 정보 🧑‍🤝‍🧑
| **이름** | **GitHub** | **담당 역할** |
|----------|-----------|--------------|
| 👨‍💻 **이동윤**  | [https://github.com/LYUN555](https://github.com/LYUN555) | 회원모드 |
| 👨‍💻 **하상우**  | [https://github.com/hsw52233](https://github.com/hsw52233) | 관리자모드 |

<br><br>



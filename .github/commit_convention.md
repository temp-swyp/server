# Udacity Git 커밋 메시지 스타일 가이드 (요약 및 번역)

**🎯 목표:** Udacity 프로젝트 평가 시 적용되는 공식 가이드라인 준수

---

커밋 메시지 작성은 훌륭한 협업의 시작입니다! 🤝 이 가이드라인을 통해 깔끔하고 이해하기 쉬운 커밋 로그를 만들어 보세요.

---

## 커밋 메시지 구조 🧱

커밋 메시지는 명확한 구조를 따릅니다. 각 부분은 빈 줄로 구분해야 합니다.


타입: 제목

본문

꼬리말

각 부분에 대해 자세히 알아볼까요?

---

## 1. 타입 (Type) ✨

커밋의 종류를 명확히 나타내는 부분입니다. 다음 중 **하나**를 선택하세요.

| 타입  | 설명                                                                |
| :---- | :------------------------------------------------------------------ |
| ✨ feat | 새로운 기능 추가 (Adding a new feature)                                |
| 🐛 fix | 버그 수정 (Fixing a bug)                                              |
| 📝 docs | 문서 변경 (Changing documentation)                                    |
| 🎨 style | 코드 스타일 변경 (Formatting, missing semi-colons, no code change) |
| 🔨 refactor | 코드 리팩토링 (Refactoring production code)                           |
| ✅ test | 테스트 추가/수정 (Adding/refactoring tests)                           |
| ⚙️ chore | 빌드 설정 변경 (Updating build tasks, package manager configs, etc)  |

---

## 2. 제목 (Subject) 📝

커밋의 핵심 내용을 간결하게 요약합니다.

*   📏 **50자 이내**로 작성하세요. 짧고 명확하게!
*   ✅ **대문자**로 시작하고, 마침표(`.`)로 끝나지 않습니다.
*   🗣️ **명령조**로 작성하세요. (예: "Add feature" 와 같이)

---

## 3. 본문 (Body) 📜 *(선택 사항)*

커밋에 대한 더 자세한 설명을 제공합니다.

*   🤔 **왜** 이 커밋을 했는지, **무엇**을 변경했는지 설명합니다.
*   코드는 **어떻게** 변경했는지 보여줍니다. (코드를 설명할 필요는 없습니다!)
*   한 줄에 **72자 이내**로 작성하여 가독성을 높입니다.
*   글머리 기호 (`-`) 를 사용하여 목록을 만들 수 있습니다.
*   제목과 본문 사이에는 **빈 줄**을 넣어주세요!

---

## 4. 꼬리말 (Footer) 🏷️ *(선택 사항)*

이슈 트래커를 참조하거나, 관련된 정보를 추가할 때 사용합니다.

*   예시:
    *   `Resolves: #123` (이 커밋으로 #123 이슈 해결)
    *   `See also: #456, #789` (관련된 이슈 #456, #789)

---

## 예시 🚀
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
IGNORE_WHEN_COPYING_END

feat: Implement user authentication with JWT

This commit adds user authentication functionality using JWT (JSON Web Tokens).

Implemented user registration and login endpoints

Added JWT token generation and verification

Updated API documentation

Resolves: #42

---

## ✨ 핵심 요약 (TL;DR) ✨

| 규칙         | 설명                                                                 |
| :----------- | :------------------------------------------------------------------- |
| **구조**       | `타입: 제목`, `본문`, `꼬리말` 로 구성, 각 부분은 빈 줄로 구분         |
| **타입**       | `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore` 중 선택 |
| **제목**       | 50자 이내, 대문자로 시작, 마침표 X, 명령조 사용                         |
| **본문**       | 왜 변경했는지 설명, 72자 이내, 제목과 분리                               |
| **꼬리말**     | 이슈 트래커 참조 등 추가 정보                                               |
| **가이드라인** | Udacity 프로젝트 평가를 위한 공식 가이드라인                             |

---

이 가이드라인을 따르면 멋진 커밋 로그를 만들 수 있습니다! 🌟 궁금한 점이 있다면 언제든지 질문해주세요! 🙋‍♀️🙋‍♂️
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
IGNORE_WHEN_COPYING_END

변경 사항:

가독성 향상: 테이블, 이모지, 가로줄 등을 사용하여 내용을 시각적으로 구분하고 가독성을 높였습니다.

친근한 어조: 팁과 격려 문구를 추가하여 사용자들이 더 쉽게 이해하고 적용하도록 유도했습니다.

핵심 내용 강조: 테이블을 사용하여 핵심 내용을 요약하고 빠르게 확인할 수 있도록 했습니다.

접근성: 모든 내용이 하나의 파일에 포함되어 있어 쉽게 공유하고 참고할 수 있습니다.

설명 추가: 각 규칙에 대한 설명을 보충하여 이해도를 높였습니다.

이 마크다운 파일은 팀원들이 Git 커밋 메시지 작성 규칙을 더 쉽고 재미있게 이해하고 적용하도록 도울 것입니다.
